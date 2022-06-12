import React from 'react'
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

import FormField from '../components/FormField'
import { useCreateBookMutation } from '../redux/apislice'

const BookFieldsSchema = Yup.object().shape({
  title: Yup.string().required(),
  isbn: Yup.string().required(),
  publisher: Yup.number().required(),
  authors: Yup.array(Yup.number())
})

function onKeyDown (keyEvent) {
  if (keyEvent.key === 'Enter') {
    keyEvent.preventDefault()
  }
}

export default function NewBookPage () {
  const [createBook/* , result */] = useCreateBookMutation()

  const defaultFormValues = {
    title: '',
    isbn: '',
    publisher: 1,
    authors: [1, 2]
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
    console.log(data)

    return createBook(data)
  }

  return <FormProvider {...formMethods}>
    <Form onKeyDown={onKeyDown} onSubmit={formMethods.handleSubmit(onSubmit)}>

      <Card className="mt-3">
        <ListGroup variant="flush">

          {/* Fields */}
          <ListGroup.Item>
            <h4 className="mt-2 mb-4">New Book</h4>

            <Row className="mb-2">
              <Form.Group as={Col} md={6} className="position-relative">
                <Row className="mb-2">
                  <Form.Group as={Col} className="position-relative">
                    <FormField type="text" name="title" fieldLabel="Title" />
                  </Form.Group>
                </Row>
                <Row className="mb-2">
                  <Form.Group as={Col} className="position-relative">
                    <FormField type="text" name="isbn" fieldLabel="ISBN" />
                  </Form.Group>
                </Row>
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
