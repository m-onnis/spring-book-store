import React from 'react'

import { useGetBooksQuery } from '../redux/apislice'

export default function HomePage (): JSX.Element {
  const { data: books, /* error, */isLoading } = useGetBooksQuery()

  if (isLoading) return <></>

  return <>
    <p style={{ marginTop: '100px' }}>{JSON.stringify(books)}</p>
  </>
}
