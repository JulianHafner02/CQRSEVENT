package at.fhv.lab1.commandclient.handler;

import at.fhv.lab1.commandclient.EventPublisher;
import at.fhv.lab1.commandclient.commands.BookRoomCommand;
import at.fhv.lab1.commandclient.commands.CancelBookingCommand;
import at.fhv.lab1.commandclient.commands.CreateCustomerCommand;
import at.fhv.lab1.eventbus.events.RoomBookedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandHandler {

    @Autowired
    private EventPublisher eventPublisher;

    public void handleBookRoomCommand(BookRoomCommand command) {
        // Validieren Sie den Befehl
        if (!command.validate()) {
            // Fehlerbehandlung für ungültige Befehle
            throw new IllegalArgumentException("Ungültiger Buchungsbefehl.");
        }
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
        // Führen Sie den Befehl aus
        // ...
    }

    public void handleCreateCustomerCommand(CreateCustomerCommand command) {
        // Validieren Sie den Befehl
        if (!command.validate()) {
            // Fehlerbehandlung für ungültige Befehle
            throw new IllegalArgumentException("Ungültiger Kunden erstellen Befehl.");
        }
        // Führen Sie den Befehl aus
        // ...
    }
}
