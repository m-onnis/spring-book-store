import React, { useEffect } from 'react'
import { FormProvider, useForm } from 'react-hook-form'
import * as Yup from 'yup'
import { yupResolver } from '@hookform/resolvers/yup'
import Form from 'react-bootstrap/Form'
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import Button from 'react-bootstrap/Button'
import Card from 'react-bootstrap/Card'
import ListGroup from 'react-bootstrap/ListGroup'
import { FaSave } from 'react-icons/fa'

import { useCreateBookMutation } from '../redux/apislice'
import { useMutationErrors } from '../hooks/resterrors'

import FormField from './form/FormField'
import AuthorsSelector from './AuthorsSelector'
import PublisherSelector from './PublisherSelector'

const BookFieldsSchema = Yup.object().shape({
  title: Yup.string().required(),
  isbn: Yup.string().required(),

  // multi selection from typeahead control (still an array)
  publisher: Yup.array(
    Yup.object().shape({
      id: Yup.number(),
      label: Yup.string()
    }))
    .min(1),

  // multi selection from typeahead
  authors: Yup.array(
    Yup.object().shape({
      id: Yup.number(),
      label: Yup.string()
    }))
    .min(1)
})

function onKeyDown (keyEvent) {
  if (keyEvent.key === 'Enter') {
    keyEvent.preventDefault()
  }
}

export default function NewBookForm () {
  const [createBook, { error }] = useCreateBookMutation()

  const defaultFormValues = {
    title: '',
    isbn: '',
    publisher: [],
    authors: []
  }

  const {
    ...formMethods
  } = useForm({
    mode: 'onChange',
    reValidateMode: 'onChange',
    defaultValues: defaultFormValues,
    resolver: yupResolver(BookFieldsSchema)
  })

  const onSubmit = (data) => {
    const book = { ...data }
    // REST API wants id or array of ids
    book.authors = data.authors.map(a => a.id)
    const [publisher] = data.publisher
    book.publisher = publisher?.id

    createBook(book)
  }

  useEffect(() => {
    if (formMethods.formState.isSubmitSuccessful) {
      formMethods.reset(defaultFormValues)
    }
  }, [formMethods])

  useMutationErrors(error, formMethods.setError)

  return <FormProvider {...formMethods}>
    <Form onKeyDown={onKeyDown} onSubmit={formMethods.handleSubmit(onSubmit)}>

      <Card className="mt-3">
        <ListGroup variant="flush">

          {/* Fields */}
          <ListGroup.Item>
            <h4 className="mt-2 mb-4">New Book</h4>

            <Row className="mb-2">
              <Form.Group as={Col} className="position-relative">
                <FormField type="text" name="title" fieldLabel="Title" />
              </Form.Group>

              <Form.Group as={Col} className="position-relative">
                <FormField type="text" name="isbn" fieldLabel="ISBN" />
              </Form.Group>
            </Row>

            <Row className="mb-2">
              <Form.Group as={Col} className="position-relative">
                <AuthorsSelector />
              </Form.Group>
              <Form.Group as={Col} className="position-relative">
                <PublisherSelector />
              </Form.Group>
            </Row>
          </ListGroup.Item>

          {/* Submit */}
          <ListGroup.Item>
            <Button type="submit" variant="success" disabled={!formMethods.formState.isValid}>
              <FaSave className="me-2 lg" />Submit
            </Button>
          </ListGroup.Item>

        </ListGroup>
      </Card>
    </Form>
  </FormProvider>
}
