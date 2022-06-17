import React from 'react'
import { Container, Nav, Navbar } from 'react-bootstrap'
import { LinkContainer } from 'react-router-bootstrap'
import { FaBook } from 'react-icons/fa'

export default function AppNavbar () {
  return <Navbar fixed="top" bg="light">
    <Container>
      <Navbar.Brand href="/">
        <FaBook size={'1.5em'} className="ms-2"/> <strong>THE BOOK STORE</strong>
      </Navbar.Brand>
      <Nav className="me-auto">
        <LinkContainer to="/books"><Nav.Link>Books</Nav.Link></LinkContainer>
        <LinkContainer to="/authors"><Nav.Link>Authors</Nav.Link></LinkContainer>
        <LinkContainer to="/publishers"><Nav.Link>Publishers</Nav.Link></LinkContainer>
        <LinkContainer to="/bootstrap"><Nav.Link>Bootstrap</Nav.Link></LinkContainer>
      </Nav>
    </Container>
  </Navbar>
}
