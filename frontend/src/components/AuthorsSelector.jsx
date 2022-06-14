import React from 'react'

import { useGetAuthorsQuery } from '../redux/apislice'

import TypeaheadField from './form/TypeaheadField'

export default function AuthorsSelector () {
  const { data: authors, isLoading } = useGetAuthorsQuery()

  if (isLoading) return null

  // typeahead controls want { id, label } objects
  const options = authors.map(a => ({
    id: a.id, label: `${a.firstName} ${a.lastName}`
  }))

  return (
    <TypeaheadField fieldLabel="Authors"
      id="multi-typeahead" name="authors" clearButton
      multiple options={options} />
  )
}
