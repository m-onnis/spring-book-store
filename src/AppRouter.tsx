import React from 'react'
import { Route, Routes } from 'react-router-dom'

import BootstrapPage from './pages/BootstrapPage'
import HomePage from './pages/HomePage'

export default function AppRouter (): JSX.Element {
  return <Routes>
    <Route path="/" element={<HomePage />} />
    <Route path="/home" element={<HomePage />} />
    <Route path="/bootstrap" element={<BootstrapPage />} />
  </Routes>
}
