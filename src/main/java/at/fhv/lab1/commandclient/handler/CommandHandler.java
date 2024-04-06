package at.fhv.lab1.commandclient.handler;

import at.fhv.lab1.commandclient.EventPublisher;
import at.fhv.lab1.commandclient.commands.BookRoomCommand;
import at.fhv.lab1.commandclient.commands.CancelBookingCommand;
import at.fhv.lab1.commandclient.commands.CreateCustomerCommand;
import at.fhv.lab1.commandclient.repositories.BookingRepository;
import at.fhv.lab1.commandclient.repositories.CustomerRepository;
import at.fhv.lab1.commandclient.repositories.RoomRepository;
import at.fhv.lab1.eventbus.events.BookingCancelledEvent;
import at.fhv.lab1.eventbus.events.CustomerCreatedEvent;
import at.fhv.lab1.eventbus.events.RoomBookedEvent;
import org.springframework.stereotype.Component;

@Component
public class CommandHandler {

    //TODO befehle auch ausführen und noch besser validieren mit den repositories

    private final EventPublisher eventPublisher;
    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final RoomRepository roomRepository;


    public CommandHandler(EventPublisher eventPublisher, BookingRepository bookingRepository, CustomerRepository customerRepository, RoomRepository roomRepository) {
        this.eventPublisher = eventPublisher;
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
        this.roomRepository = roomRepository;
    }


    public void handleBookRoomCommand(BookRoomCommand command) {
        // Validieren Sie den Befehl
        if (!command.validate()) {
            // Fehlerbehandlung für ungültige Befehle
            throw new IllegalArgumentException("Ungültiger Buchungsbefehl.");
        }
        //TODO befehl auch ausführen

        // Nach erfolgreicher Verarbeitung des Befehls, Ereignis erstellen und veröffentlichen
        RoomBookedEvent event = new RoomBookedEvent();
        event.setRoomNumber(command.getRoomNumber());
        event.setCustomerId(command.getCustomerId());
        event.setStartTime(command.getStartTime());
        event.setEndTime(command.getEndTime());

        eventPublisher.publishEvent(event);
    }

    public void handleCancelBookingCommand(CancelBookingCommand command) {
        // Validieren Sie den Befehl
        if (!command.validate()) {
            // Fehlerbehandlung für ungültige Befehle
            throw new IllegalArgumentException("Ungültiger Stornierungsbefehl.");
        }
        // TODO Logik zur Stornierung der Buchung

        // Nach erfolgreicher Stornierung, Ereignis erstellen und veröffentlichen
        BookingCancelledEvent event = new BookingCancelledEvent();
        event.setReservationNumber(command.getReservationNumber());

        eventPublisher.publishEvent(event);
    }

    public void handleCreateCustomerCommand(CreateCustomerCommand command) {
        // Validieren Sie den Befehl
        if (!command.validate()) {
            // Fehlerbehandlung für ungültige Befehle
            throw new IllegalArgumentException("Ungültiger Kunden erstellen Befehl.");
        }
        // TODO Führen Sie den Befehl aus

        //Nach erfolgreicher Erstellung, Ereignis erstellen und veröffentlichen
        CustomerCreatedEvent event = new CustomerCreatedEvent();
        event.setName(command.getName());
        event.setAddress(command.getAddress());
        event.setDateOfBirth(command.getDateOfBirth());

        eventPublisher.publishEvent(event);
    }
}
