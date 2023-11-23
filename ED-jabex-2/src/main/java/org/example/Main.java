package org.example;

import generated.ObjectFactory;
import generated.PurchaseOrder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        ObjectFactory factory = new ObjectFactory();

        PurchaseOrder order = factory.createPurchaseOrder();

        PurchaseOrder.ShipTo shipTo = factory.createPurchaseOrderShipTo();

        shipTo.setName("Jan Kowalski");
        shipTo.setCity("Poznań");
        shipTo.setCountry("Poland");
        shipTo.setZip("60-687");
        shipTo.setState("Wielkopolska");

        order.setShipTo(shipTo);


        PurchaseOrder.BillTo billTo = factory.createPurchaseOrderBillTo();


        billTo.setName("Jan Kowalski");
        billTo.setCity("Poznań");
        billTo.setCountry("Poland");
        billTo.setZip("60-687");
        billTo.setState("Wielkopolska");

        order.setBillTo(billTo);

        JAXBContext jaxContext = null;
        Marshaller marshaller;
        try {
            jaxContext = JAXBContext.newInstance(PurchaseOrder.class);
            marshaller = jaxContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            File file = new File("order.xml");

            marshaller.marshal(order, file);
            marshaller.marshal(order, System.out);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}