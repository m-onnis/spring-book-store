import React from 'react'
import { Container, Nav, Navbar } from 'react-bootstrap'
import { LinkContainer } from 'react-router-bootstrap'

export default function AppNavbar () {
  return <Navbar fixed="top" bg="light">
    <Container>
      <Navbar.Brand href="/">Navbar</Navbar.Brand>
      <Nav className="me-auto">
        <LinkContainer to="/home"><Nav.Link>Home</Nav.Link></LinkContainer>
        <LinkContainer to="/bootstrap"><Nav.Link>Bootstrap</Nav.Link></LinkContainer>
      </Nav>
    </Container>
  </Navbar>
}
