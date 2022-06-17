import React from 'react'
import { Route, Routes } from 'react-router-dom'

import BooksPage from './pages/BooksPage'
import AuthorsPage from './pages/AuthorsPage'
import BootstrapPage from './pages/BootstrapPage'
import PublishersPage from './pages/PublishersPage'

export default function AppRouter () {
  return <Routes>
    <Route path="/" element={<BooksPage />} />
    <Route path="/home" element={<BooksPage />} />
    <Route path="/books" element={<BooksPage />} />
    <Route path="/authors" element={<AuthorsPage />} />
    <Route path="/publishers" element={<PublishersPage />} />
    <Route path="/bootstrap" element={<BootstrapPage />} />
  </Routes>
}
