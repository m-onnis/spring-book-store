import React from 'react'

import { useGetPublishersQuery } from '../redux/apislice'

import TypeaheadField from './form/TypeaheadField'

export default function PublisherSelector () {
  const { data: publishers, isLoading } = useGetPublishersQuery()

  if (isLoading) return null

  // typeahead controls want { id, label } objects
  const options = publishers.map(p => ({
    id: p.id, label: p.name
  }))

  return (
    <TypeaheadField fieldLabel="Publishers" name="publisher"
      placeholder="Choose publishers..."
      id="typeahead"
      options={options} />
  )
}
