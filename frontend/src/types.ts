export interface Author {
  firstName: string
  lastName: string
}

export interface Publisher {
  name: string
}

export interface Book {
  id: number
  title: string
  isbn: string

  authors: Author[]
  publisher: Publisher
}
