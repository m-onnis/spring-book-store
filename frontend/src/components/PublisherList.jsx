import React, { useEffect } from 'react'
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import Card from 'react-bootstrap/Card'
import ListGroup from 'react-bootstrap/ListGroup'
import Form from 'react-bootstrap/Form'
import * as Yup from 'yup'
import { yupResolver } from '@hookform/resolvers/yup'
import { FormProvider, useForm } from 'react-hook-form'
import Button from 'react-bootstrap/Button'
import { FaPlus } from 'react-icons/fa'

import { useMutationErrors } from '../hooks/resterrors'
import { useCreatePublisherMutation, useGetPublishersQuery } from '../redux/apislice'

import FormField from './form/FormField'

const PublisherRow = ({ publisher }) => {
  return <ListGroup.Item>
    <Row>
      <Col sm={3}>{publisher.name}</Col>
    </Row>
  </ListGroup.Item>
}

const PublisherFieldsSchema = Yup.object().shape({
  name: Yup.string().required()
})

const defaultFormValues = { name: '' }

const NewPublisherRow = () => {
  const [createPublisher, { error }] = useCreatePublisherMutation()

  const {
    ...formMethods
  } = useForm({
    mode: 'onChange',
    reValidateMode: 'onChange',
    defaultValues: defaultFormValues,
    resolver: yupResolver(PublisherFieldsSchema)
  })

  useEffect(() => {
    if (formMethods.formState.isSubmitSuccessful) {
      formMethods.reset(defaultFormValues)
    }
  }, [formMethods])

  useMutationErrors(error, formMethods.setError)

  const onSubmit = (values) => {
    // form values should match REST API
    createPublisher(values)
  }

  return <FormProvider { ...formMethods }>
    <Form onSubmit={ formMethods.handleSubmit(onSubmit) }>
      <Row className="mb-2">
        <Form.Group as={Col} sm={3} className="position-relative">
          <FormField type="text" label="Name" name="name" />
        </Form.Group>
        <Col>
          <Button type="submit" variant="success" disabled={ !formMethods.formState.isValid }>
            <FaPlus className="me-2 lg"/>Add
          </Button>
        </Col>
      </Row>
    </Form>
  </FormProvider>
}

export default function PublishersList () {
  const { data: publishers, isLoading } = useGetPublishersQuery()

  if (isLoading) return <></>

  return <>
    <Card>
      <Card.Body>
        <Card.Text>
          <Row>
            <Col>
              <Row>
                <Col><h3>Publishers</h3></Col>
              </Row>
              <Row>
                <Col>This is the list of existing publishers.</Col>
              </Row>
            </Col>
          </Row>
        </Card.Text>
      </Card.Body>

      <ListGroup variant="flush">

        <ListGroup.Item>
          <Row>
            <Col sm={3}><strong>Name</strong></Col>
            <Col></Col>
          </Row>
        </ListGroup.Item>

        {publishers?.map(p => <PublisherRow key={p.id} publisher={p} />)}

        <ListGroup.Item>
          <NewPublisherRow />
        </ListGroup.Item>

      </ListGroup>

    </Card>
  </>
}
