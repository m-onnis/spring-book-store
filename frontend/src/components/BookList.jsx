import React, { useState } from 'react'
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import Card from 'react-bootstrap/Card'
import ListGroup from 'react-bootstrap/ListGroup'
import Button from 'react-bootstrap/Button'
import { FaTrash } from 'react-icons/fa'
import Modal from 'react-bootstrap/Modal'

import { useDeleteBookMutation, useGetBooksQuery } from '../redux/apislice'

import NewBookForm from './NewBookForm'

const BookRow = ({ book }) => {
  const authors = book.authors
    .map(a => `${a.firstName} ${a.lastName}`)
    .join(', ')

  const [deleteBook/* , { error } */] = useDeleteBookMutation()
  const [showModal, setShowModal] = useState(false)
  const closeModal = () => setShowModal(false)

  const deleteBookAndCloseModal = (id) => {
    deleteBook(id)
    closeModal()
  }

  return <ListGroup.Item>
    <Row>
      <Col sm={3}>{book.title}</Col>
      <Col sm={2}>{book.isbn}</Col>
      <Col sm={2}>{book.publisher.name}</Col>
      <Col>{authors}</Col>
      <Col sm="auto">
        <Button variant="success" onClick={ () => setShowModal(true) } className="ms-1" size="sm">
          <FaTrash cursor="pointer" title="Delete" />
        </Button>
      </Col>
    </Row>

    <Modal show={ showModal } onHide={ closeModal }>
      <Modal.Header closeButton>
        <Modal.Title>Delete confirmation</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        You confirm the deletion of book <strong>{ book.title }</strong>?
      </Modal.Body>
      <Modal.Footer>
        <Button variant="secondary" onClick={ closeModal }>
          No
        </Button>
        <Button variant="success" onClick={ () => deleteBookAndCloseModal(book.id) }>
          Yes
        </Button>
      </Modal.Footer>
    </Modal>
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
            <Col sm={3}><strong>Title</strong></Col>
            <Col sm={2}><strong>ISBN</strong></Col>
            <Col sm={2}><strong>Publisher</strong></Col>
            <Col><strong>Authors</strong></Col>
          </Row>
        </ListGroup.Item>

        {books?.map(b => <BookRow key={b.id} book={b} />)}

      </ListGroup>

    </Card>

    <NewBookForm />
  </>
}
