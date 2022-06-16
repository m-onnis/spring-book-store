import React from 'react'
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import Card from 'react-bootstrap/Card'
import ListGroup from 'react-bootstrap/ListGroup'

import { useGetBooksQuery } from '../redux/apislice'

import NewBookForm from './NewBookForm'

const BookRow = ({ book }) => {
  const authors = book.authors
    .map(a => `${a.firstName} ${a.lastName}`)
    .join(', ')

  return <ListGroup.Item>
    <Row>
      <Col>{book.title}</Col>
      <Col>{book.isbn}</Col>
      <Col>{book.publisher.name}</Col>
      <Col>{authors}</Col>
    </Row>
  </ListGroup.Item>
}

export default function BookList () {
  const { data: books, isLoading } = useGetBooksQuery()

  if (isLoading) return <></>

  return <>
    <Card>
      <Card.Body>
        <Card.Text>
          <Row>
            <Col>
              <Row>
                <Col><h3>Books</h3></Col>
              </Row>
              <Row>
                <Col>This is the list of existing books.</Col>
              </Row>
            </Col>
          </Row>
        </Card.Text>
      </Card.Body>

      <ListGroup variant="flush">

        <ListGroup.Item>
          <Row>
            <Col><strong>Title</strong></Col>
            <Col><strong>ISBN</strong></Col>
            <Col><strong>Publisher</strong></Col>
            <Col><strong>Authors</strong></Col>
          </Row>
        </ListGroup.Item>

        {books?.map(b => <BookRow key={b.id} book={b} />)}

      </ListGroup>

    </Card>

    <NewBookForm />
  </>
}
