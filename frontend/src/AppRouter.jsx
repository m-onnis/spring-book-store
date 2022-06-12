import React from 'react'
import { Route, Routes } from 'react-router-dom'

import BootstrapPage from './pages/BootstrapPage'
import HomePage from './pages/HomePage'
import NewBookPage from './pages/NewBookPage'

export default function AppRouter () {
  return <Routes>
    <Route path="/" element={<HomePage />} />
    <Route path="/home" element={<HomePage />} />
    <Route path="/book/new" element={<NewBookPage />} />
    <Route path="/bootstrap" element={<BootstrapPage />} />
  </Routes>
}
