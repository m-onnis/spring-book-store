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

import { useCreateAuthorMutation, useGetAuthorsQuery } from '../redux/apislice'

import FormField from './form/FormField'

const AuthorRow = ({ author }) => {
  return <ListGroup.Item>
    <Row>
      <Col sm={3}>{author.firstName}</Col>
      <Col sm={3}>{author.lastName}</Col>
    </Row>
  </ListGroup.Item>
}

const AuthorFieldsSchema = Yup.object().shape({
  firstName: Yup.string().required(),
  lastName: Yup.string().required()
})

const defaultFormValues = { firstName: '', lastName: '' }

const NewAuthorRow = () => {
  const [createAuthor/* , result */] = useCreateAuthorMutation()

  const {
    ...formMethods
  } = useForm({
    mode: 'onChange',
    reValidateMode: 'onChange',
    defaultValues: defaultFormValues,
    resolver: yupResolver(AuthorFieldsSchema)
  })

  useEffect(() => {
    if (formMethods.formState.isSubmitSuccessful) {
      formMethods.reset(defaultFormValues)
    }
  }, [formMethods])

  // useMutationErrors(error, formMethods.setError)

  const onSubmit = (values) => {
    // form values should match REST API
    createAuthor(values)
  }

  return <FormProvider { ...formMethods }>
    <Form onSubmit={ formMethods.handleSubmit(onSubmit) }>
      <Row className="mb-2">
        <Form.Group as={Col} sm={3} className="position-relative">
          <FormField type="text" label="First Name" name="firstName" />
        </Form.Group>
        <Form.Group as={Col} sm={3} className="position-relative">
          <FormField type="text" label="Last Name" name="lastName" />
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

export default function AuthorList () {
  const { data: authors, isLoading } = useGetAuthorsQuery()

  if (isLoading) return <></>

  return <>
    <Card>
      <Card.Body>
        <Card.Text>
          <Row>
            <Col>
              <Row>
                <Col><h3>Authors</h3></Col>
              </Row>
              <Row>
                <Col>This is the list of existing authors.</Col>
              </Row>
            </Col>
          </Row>
        </Card.Text>
      </Card.Body>

      <ListGroup variant="flush">

        <ListGroup.Item>
          <Row>
            <Col sm={3}><strong>First Name</strong></Col>
            <Col sm={3}><strong>Last Name</strong></Col>
            <Col></Col>
          </Row>
        </ListGroup.Item>

        {authors?.map(a => <AuthorRow key={a.id} author={a} />)}

        <ListGroup.Item>
          <NewAuthorRow />
        </ListGroup.Item>

      </ListGroup>

    </Card>
  </>
}
