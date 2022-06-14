import React from 'react'
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import Card from 'react-bootstrap/Card'
import Button from 'react-bootstrap/Button'
import ListGroup from 'react-bootstrap/ListGroup'
import { LinkContainer } from 'react-router-bootstrap'

import { useGetBooksQuery } from '../redux/apislice'

const BookRow = ({ book }) => {
  const authors = book.authors
    .map(a => [a.firstName, a.lastName].join(' '))
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
            <Col>Title</Col>
            <Col>ISBN</Col>
            <Col>Publisher</Col>
            <Col>Authors</Col>
          </Row>
        </ListGroup.Item>

        {books?.map(b => <BookRow key={b.id} book={b} />)}

        <ListGroup.Item>
          <LinkContainer to="/books/new">
            <Button>New Book</Button>
          </LinkContainer>
        </ListGroup.Item>

      </ListGroup>

    </Card>
  </>
}
