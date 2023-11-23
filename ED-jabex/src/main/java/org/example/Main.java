package org.example;

import com.sun.xml.bind.v2.runtime.JAXBContextImpl;
import generated.ObjectFactory;
import generated.PurchaseOrder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) {
// System.out.println("Hello world!");
        ObjectFactory factory = new ObjectFactory();

        PurchaseOrder order = factory.createPurchaseOrder();


        PurchaseOrder.BillTo billTo = factory.createPurchaseOrderBillTo();

        billTo.setName("Tomasz Chick");
        billTo.setCity("Warsaw");
        billTo.setCountry("Poland");
        billTo.setZip("00-019");
        billTo.setState("Mazowieckie");
        billTo.setStreet("Zlota");

        order.setBillTo(billTo);


        PurchaseOrder.ShipTo shipTo = factory.createPurchaseOrderShipTo();

        shipTo.setName("Tomasz Chick");
        shipTo.setCity("Warsaw");
        shipTo.setCountry("Poland");
        shipTo.setZip("00-019");
        shipTo.setState("Mazowieckie");
        shipTo.setStreet("Zlota");

        order.setShipTo(shipTo);


// JAXBContext jaxContext = null;
//
// try {
// jaxContext = JAXBContext.newInstance(PurchaseOrder.class);
// Marshaller marshaller;
// marshaller = jaxContext.createMarshaller();
//
// marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//
// File file = new File ("order.xml");
//
// marshaller.marshal(order, file);
// marshaller.marshal(order, System.out);
// } catch (JAXBException e) {
// throw new RuntimeException(e);
// }

        try {
            JAXBContext jaxContext = JAXBContext.newInstance(PurchaseOrder.class);
            Unmarshaller unmarshaller = jaxContext.createUnmarshaller();

            File file = new File("order.xml");
            PurchaseOrder wczytane = (PurchaseOrder) unmarshaller.unmarshal(file);
            System.out.println(wczytane.getBillTo().getName());
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}