package com.zjuee.enumerated;

import java.util.*;

class Mail {
    enum Redirect {YES, NO1, NO2, NO3, NO4, NO5}
    enum GeneralDelivery {YES, NO1, NO2, NO3, NO4, NO5}
    enum Scannability {UNSACCANNABLE, YES1, YES2, YES3, YES4, YES5}
    enum Readability {ILLEGIBLE, YES1, YES2, YES3, YES4, YES5}
    enum Address {INCORRECT, OK1, OK2, OK3, OK4, OK5}
    enum ReturnAddress {MISSING, OK1, OK2, OK3, OK4, OK5}
    Redirect redirect;
    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;
    static long counter = 0;
    long id = counter++;
    public String toString() {
        return "Mail " + id;
    }
    public String details() {
        return this +
                ", Redirect " + redirect +
                ", General Delivery " + generalDelivery +
                ", Scan Ability " + scannability +
                ", Read Ability " + readability +
                ", Address " + address +
                ", Return Address " + returnAddress;
    }
    public static Mail randomMail() {
        Mail mail = new Mail();
        mail.redirect = Enums.random(Redirect.class);
        mail.generalDelivery = Enums.random(GeneralDelivery.class);
        mail.readability = Enums.random(Readability.class);
        mail.address = Enums.random(Address.class);
        mail.returnAddress = Enums.random(ReturnAddress.class);
        mail.scannability = Enums.random(Scannability.class);
        return mail;
    }
    public static Iterable<Mail> generator(final int count) {
        return new Iterable<>() {
            int n = count;
            public Iterator<Mail> iterator() {
                return new Iterator<>() {
                    public boolean hasNext() {
                        return n-- > 0;
                    }
                    public Mail next() {
                        return randomMail();
                    }
                };
            }
        };
    }
}

public class PostOffice {
    enum MailHandler {
        REDIRECT_MAIL {
            boolean handle(Mail m) {
                switch (m.redirect) {
                    case YES:
                        System.out.println("Redirect the delivery " + m);
                        return true;
                    default:
                        return false;
                }
            }
        },
        GENERAL_DELIVERY {
            boolean handle(Mail m) {
                switch (m.generalDelivery) {
                    case YES:
                        System.out.println("Using general delivery for " + m);
                        return true;
                    default:
                        return false;
                }
            }
        },
        MACHINE_SCAN {
            boolean handle(Mail m) {
                switch (m.scannability) {
                    case UNSACCANNABLE:
                        return false;
                    default:
                        switch (m.address) {
                            case INCORRECT: return false;
                            default:
                                System.out.println("Delivering " + m + " automatically");
                                return true;
                        }
                }
            }
        },
        VISUAL_INSPECTION {
            boolean handle(Mail m) {
                switch (m.readability) {
                    case ILLEGIBLE: return false;
                    default:
                        switch (m.address) {
                            case INCORRECT: return false;
                            default:
                                System.out.println("Delivering " + m + " normally");
                                return true;
                        }
                }
            }
        },
        RETURN_TO_SENDER {
            boolean handle(Mail m) {
                switch (m.returnAddress) {
                    case MISSING: return false;
                    default:
                        System.out.println("Returning " + m + " to sender");
                        return true;
                }
            }
        };
        abstract boolean handle(Mail m);
    }
    static void handle(Mail m) {
        for (MailHandler mailHandler : MailHandler.values())
            if(mailHandler.handle(m)) return;
        System.out.println(m + " is a dead letter");
    }

    public static void main(String[] args) {
        for (Mail m : Mail.generator(20)) {
            System.out.println(m.details());
            handle(m);
            System.out.println("------");
        }
    }
}
