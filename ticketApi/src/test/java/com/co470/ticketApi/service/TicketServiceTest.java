package com.co470.ticketApi.service;

import com.co470.ticketApi.dao.TicketDao;
import com.co470.ticketApi.entities.Ticket;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class TicketServiceTest {

    @Mock
    TicketDao ticketDao;
    @InjectMocks
    TicketService ticketService;

    @Test
    void createTicket(){
        Ticket ticket = new Ticket();
        ticket.setTicketId(1);
        ticket.setBookingDate(new Date());
        ticket.setEmail("juan.perez@gmail.com");
        ticket.setPassengerName("Juan Perez");
        ticket.setSourceStation("Sucre");
        ticket.setDestStation("Potosi");
        when(ticketDao.save(ticket)).thenReturn(ticket);
        assertEquals(ticket,ticketService.createTicket(ticket));
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
        when(ticketDao.findById(1)).thenReturn(Optional.of(ticket));
        assertEquals(ticket.getTicketId(),ticketService.getTicketById(1).getTicketId());
    }

    @Test
    void getAllTickets() {
        Ticket ticket = new Ticket();
        ticket.setTicketId(1);
        ticket.setBookingDate(new Date());
        ticket.setEmail("juan.perez@gmail.com");
        ticket.setPassengerName("Juan Perez");
        ticket.setSourceStation("Sucre");
        ticket.setDestStation("Potosi");
        Ticket ticket2 = new Ticket();
        ticket2.setTicketId(1);
        ticket2.setBookingDate(new Date());
        ticket2.setEmail("juan.perez@gmail.com");
        ticket2.setPassengerName("Juan Perez");
        ticket2.setSourceStation("Sucre");
        ticket2.setDestStation("Potosi");
        List<Ticket> ListaTickets = new ArrayList<>();
        ListaTickets.add(ticket);
        ListaTickets.add(ticket2);
        when(ticketDao.findAll()).thenReturn(ListaTickets);
        assertEquals(ListaTickets.size(), ((Collection<?>) ticketService.getAllTickets()).size());

    }

    @Test
    void deleteTicket() {

        Ticket ticket = new Ticket();
        //ticket.setTicketId(1);
        ticketService.deleteTicket(1);
        verify(ticketDao).deleteById(1);
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
        when(ticketDao.findById(1)).thenReturn(Optional.of(ticket));
        ticket.setEmail("xxxxaaa@gmail.com");
        when(ticketDao.save(ticket)).thenReturn(ticket);
        assertEquals(ticket,ticketService.updateTicket(ticket.getTicketId(),ticket.getEmail()));
    }
}