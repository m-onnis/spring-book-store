import React from 'react'
import { Container } from 'react-bootstrap'
import { BrowserRouter } from 'react-router-dom'

import './App.css'
import AppRouter from './AppRouter'

function App (): JSX.Element {
  return <BrowserRouter>
    <Container>
      <AppRouter />
    </Container>
  </BrowserRouter>
}

export default App
