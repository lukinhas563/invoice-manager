package org.example.builder;

import org.example.model.address.Address;
import org.example.model.invoice.Service;
import org.example.model.person.Individual;
import org.example.model.person.Legal;
import org.example.model.person.Person;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class ServiceInvoiceBuilder extends Builder{

    public ServiceInvoiceBuilder(Document document) {
        super(document);
    }

    public ServiceInvoiceBuilder makeInfo() {

        key = document.getElementsByTagName("infNFSe").item(0).getAttributes().item(0).getTextContent();
        String infoNumber = document.getElementsByTagName("nNFSe").item(0).getTextContent();
        number = Integer.parseInt(infoNumber);

        competence = document.getElementsByTagName("dhProc").item(0).getTextContent();
        series = document.getElementsByTagName("serie").item(0).getTextContent();
        code = document.getElementsByTagName("xTribNac").item(0).getTextContent();
        description = document.getElementsByTagName("xDescServ").item(0).getTextContent();
        locationProvision = document.getElementsByTagName("xLocPrestacao").item(0).getTextContent();

        String infoNetValue = document.getElementsByTagName("vServ").item(0).getTextContent();
        netValue = Double.parseDouble(infoNetValue);

        return this;
    }

    public ServiceInvoiceBuilder makeSender() {
        NodeList nodeSender = document.getElementsByTagName("emit").item(0).getChildNodes();

        sender = this.makePerson(nodeSender);

        return this;
    }

    public ServiceInvoiceBuilder makeRecipient() {
        NodeList nodeRecipient = document.getElementsByTagName("toma").item(0).getChildNodes();

        recipient = this.makePerson(nodeRecipient);

        return this;
    }

    private Person makePerson(NodeList nodeList) {

        Person person = null;

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node item = nodeList.item(i);

            if(item.getNodeName().equals("CNPJ")) {
                person = this.makeLegalPerson(nodeList);
            } else if (item.getNodeName().equals("CPF")) {
                person =  this.makeIndividualPerson(nodeList);
            }
        }

        return person;
    }

    public Individual makeIndividualPerson(NodeList nodeItem) {
        System.out.println("CPF");
        return new Individual("", "", "", "", new Address("", "", ""));
    }

    public Legal makeLegalPerson(NodeList nodeList) {

        String identification = "";
        String name = "";
        String tel = "";
        String email = "";
        Address address = new Address("", "", "");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node item = nodeList.item(i);

            if (item.getNodeName().equals("CNPJ")) {
                identification = item.getTextContent();
            }
            if (item.getNodeName().equals("xNome")) {
                name = item.getTextContent();
            }
            if (item.getNodeName().equals("fone")) {
                tel = item.getTextContent();
            }
            if (item.getNodeName().equals("email")) {
                email = item.getTextContent();
            }
            if(item.getNodeName().equals("end")) {
                NodeList nodeListAddress = item.getChildNodes();
                address = this.makeAddress(nodeListAddress);
                continue;
            }
            if (item.getNodeName().equals("enderNac")) {
                NodeList nodeListAddress = item.getChildNodes();
                address = this.makeAddress(nodeListAddress);
            }
        }

        return new Legal( name, identification, email, tel, "Simples Nacional", address);
    }

    public Address makeAddress(NodeList nodeList) {
        String address = "";
        String city = "";
        String zipCode = "";

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node item = nodeList.item(i);

            if (item.getNodeName().equals("xLgr")) {
                address = item.getTextContent();
            }
            if (item.getNodeName().equals("xBairro")) {
                city = item.getTextContent();
            }
            if (item.getNodeName().equals("CEP")) {
                zipCode = item.getTextContent();
            }
            if (item.getNodeName().equals("endNac")) {
                NodeList nodeListAddress = item.getChildNodes();

                for (int j = 0; j < nodeListAddress.getLength(); j++) {
                    Node addressItem = nodeListAddress.item(j);
                    if(addressItem.getNodeName().equals("CEP")) {
                        zipCode = addressItem.getTextContent();
                    }
                }

                zipCode = item.getTextContent();
            }

        }

        return new Address(address, city, zipCode);
    }

    public Service makeServiceInvoice() {
        this.makeInfo().makeSender().makeRecipient();
        return new Service(key, number, competence, series, netValue, sender, recipient, code, description, locationProvision);
    }

}
