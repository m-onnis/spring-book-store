import { AxiosResponse } from 'axios'
import React, { useEffect, useState } from 'react'

import axios from '../utils/axiosbackend'

interface Book {
  title: string
  isbn: string
}

const getBooks = async (): Promise<Book[]> => {
  // const response: Response = await fetch('http://localhost:8080/books')

  const response: AxiosResponse = await axios.get('/books')

  console.log(response.data.content)

  return response.data.content
}

export default function HomePage (): JSX.Element {
  const [books, setBooks] = useState<Book[]>([])

  useEffect(() => {
    const perform = async (): Promise<void> => {
      const theBooks: Book[] = await getBooks()
      setBooks(theBooks)
    }

    void perform()
  }, [])

  return <>
    <p style={{ marginTop: '100px' }}>{JSON.stringify(books)}</p>
  </>
}
