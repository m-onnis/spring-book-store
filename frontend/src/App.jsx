import React from 'react'
import { Container } from 'react-bootstrap'
import { BrowserRouter } from 'react-router-dom'
import { Provider } from 'react-redux'

import './App.css'
import AppNavbar from './AppNavbar'
import AppRouter from './AppRouter'
import { store } from './redux/store'

export default function App () {
  return (
    <Provider store={store}>
      <BrowserRouter>
        <Container>
          <AppNavbar />
          <AppRouter />
        </Container>
      </BrowserRouter>
    </Provider>
  )
}
