import React from 'react'
import { Container } from 'react-bootstrap'
import { BrowserRouter } from 'react-router-dom'

import './App.css'
import AppNavbar from './AppNavbar'
import AppRouter from './AppRouter'

export default function App (): JSX.Element {
  return <BrowserRouter>
    <Container>
      <AppNavbar />
      <AppRouter />
    </Container>
  </BrowserRouter>
}
