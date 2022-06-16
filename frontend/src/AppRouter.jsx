import React from 'react'
import { Route, Routes } from 'react-router-dom'

import AuthorsPage from './pages/AuthorsPage'
import BootstrapPage from './pages/BootstrapPage'
import HomePage from './pages/HomePage'
import NewBookPage from './pages/NewBookPage'
import PublishersPage from './pages/PublishersPage'

export default function AppRouter () {
  return <Routes>
    <Route path="/" element={<HomePage />} />
    <Route path="/home" element={<HomePage />} />
    <Route path="/authors" element={<AuthorsPage />} />
    <Route path="/publishers" element={<PublishersPage />} />
    <Route path="/books/new" element={<NewBookPage />} />
    <Route path="/bootstrap" element={<BootstrapPage />} />
  </Routes>
}
