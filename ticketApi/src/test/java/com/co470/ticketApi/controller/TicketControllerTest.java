package com.co470.ticketApi.controller;

import com.co470.ticketApi.entities.Ticket;
import com.co470.ticketApi.service.TicketService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class TicketControllerTest {

    @Mock
    TicketService ticketService;
    @InjectMocks
    private TicketController ticketController;

    @Test
    void createTicket() {
        Ticket ticket = new Ticket();
        ticket.setTicketId(1);
        ticket.setBookingDate(new Date());
        ticket.setEmail("juan.perez@gmail.com");
        ticket.setPassengerName("Juan Perez");
        ticket.setSourceStation("Sucre");
        ticket.setDestStation("Potosi");
        ticketController.createTicket(ticket);
        verify(ticketService).createTicket(ticket);
    }

    @Test
    void getTicketById() {
        Ticket ticket = new Ticket();
        ticket.setTicketId(1);
        ticket.setBookingDate(new Date());
        ticket.setEmail("juan.perez@gmail.com");
        ticket.setPassengerName("Juan Perez");
        ticket.setSourceStation("Sucre");
        ticket.setDestStation("Potosi");
        ticketController.getTicketById(ticket.getTicketId());
        verify(ticketService).getTicketById(ticket.getTicketId());
    }

    @Test
    void getAllTickets() {
        ArrayList<Ticket> listatickets = new ArrayList<Ticket>();
        listatickets.add(new Ticket());
        listatickets.add(new Ticket());
        listatickets.add(new Ticket());
        ticketController.getAllTickets();
        verify(ticketService).getAllTickets();
    }

    @Test
    void deleteTicket() {
        Ticket ticket = new Ticket();
        ticket.setTicketId(1);
        ticket.setBookingDate(new Date());
        ticket.setEmail("juan.perez@gmail.com");
        ticket.setPassengerName("Juan Perez");
        ticket.setSourceStation("Sucre");
        ticket.setDestStation("Potosi");
        ticketController.deleteTicket(1);
        verify(ticketService).deleteTicket(1);
    }

    @Test
    void updateTicket() {
        Ticket ticket = new Ticket();
        ticket.setTicketId(1);
        ticket.setBookingDate(new Date());
        ticket.setEmail("juan.perez@gmail.com");
        ticket.setPassengerName("Juan Perez");
        ticket.setSourceStation("Sucre");
        ticket.setDestStation("Potosi");

        ticketController.updateTicket(ticket.getTicketId(),ticket.getEmail());
        verify(ticketService).updateTicket(ticket.getTicketId(), ticket.getEmail());
    }
}