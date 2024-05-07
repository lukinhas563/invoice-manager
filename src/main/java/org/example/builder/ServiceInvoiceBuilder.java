package org.example.builder;

import org.example.model.address.Address;
import org.example.model.invoice.Service;
import org.example.model.person.Individual;
import org.example.model.person.Legal;
import org.example.model.person.Person;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.time.LocalDate;


public class ServiceInvoiceBuilder implements Builder{

    protected final Document document;

    protected String key;
    protected int number;
    protected LocalDate competence;
    protected String series;
    protected String code;
    protected String description;
    protected String locationProvision;
    protected String tax;

    protected double netValue;

    protected Person sender;
    protected Person recipient;

    public ServiceInvoiceBuilder(Document document) {
        this.document = document;
    }

    public ServiceInvoiceBuilder makeInfo() {

        this.key = this.document.getElementsByTagName("infNFSe").item(0).getAttributes().item(0).getTextContent();
        String infoNumber = this.document.getElementsByTagName("nNFSe").item(0).getTextContent();
        this.number = Integer.parseInt(infoNumber);

        String dateResult = this.document.getElementsByTagName("dhProc").item(0).getTextContent();
        String[] date = dateResult.split("T");
        this.competence = LocalDate.parse(date[0]);

        String taxContent = this.document.getElementsByTagName("opSimpNac").item(0).getTextContent();
        if (taxContent.equals("1") || taxContent.equals("2")) {
            this.tax = "Simples Nacional";
        } else {
            this.tax = "Lucro Presumido";
        }

        this.series = this.document.getElementsByTagName("serie").item(0).getTextContent();
        this.code = this.document.getElementsByTagName("xTribNac").item(0).getTextContent();
        this.description = this.document.getElementsByTagName("xDescServ").item(0).getTextContent();
        this.locationProvision = this.document.getElementsByTagName("xLocPrestacao").item(0).getTextContent();

        String infoNetValue = document.getElementsByTagName("vServ").item(0).getTextContent();
        this.netValue = Double.parseDouble(infoNetValue);

        return this;
    }

    public ServiceInvoiceBuilder makeSender() {
        NodeList nodeSender = this.document.getElementsByTagName("emit").item(0).getChildNodes();
        String type = this.document.getElementsByTagName("emit").item(0).getNodeName();

        this.sender = this.makePerson(nodeSender, type);

        return this;
    }

    public ServiceInvoiceBuilder makeRecipient() {
        NodeList nodeRecipient = this.document.getElementsByTagName("toma").item(0).getChildNodes();
        String type = this.document.getElementsByTagName("toma").item(0).getNodeName();

        this.recipient = this.makePerson(nodeRecipient, type);

        return this;
    }

    private Person makePerson(NodeList nodeList, String type) {

        Person person = null;

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node item = nodeList.item(i);

            if(item.getNodeName().equals("CNPJ")) {
                person = this.makeLegalPerson(nodeList, type);
            } else if (item.getNodeName().equals("CPF")) {
                person =  this.makeIndividualPerson(nodeList);
            }
        }

        return person;
    }

    private Individual makeIndividualPerson(NodeList nodeItem) {
        System.out.println("CPF");
        return new Individual("", "", "", "", new Address("", "", ""));
    }

    private Legal makeLegalPerson(NodeList nodeList, String type) {

        String identification = "";
        String name = "";
        String tel = "";
        String email = "";
        String tax = type.equals("emit") ? this.tax : "";

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

        return new Legal( name, identification, email, tel, tax, address);
    }

    private Address makeAddress(NodeList nodeList) {
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
                zipCode = item.getTextContent();
            }

        }

        return new Address(address, city, zipCode);
    }

    public Service makeServiceInvoice() {
        return new Service(this.key, this.number, this.competence, this.series, this.netValue, this.sender, this.recipient, this.code, this.description, this.locationProvision);
    }

}
