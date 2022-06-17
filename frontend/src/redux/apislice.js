// Import the RTK Query methods from the React-specific entry point
import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react'

import config from '../config'

// Define our single API slice object
export const apiSlice = createApi({
  // The cache reducer expects to be added at `state.api` (already default - this is optional)
  reducerPath: 'api',
  // All of our requests will have URLs starting with config.apiUrl
  baseQuery: fetchBaseQuery({ baseUrl: config.apiUrl }),
  // The "endpoints" represent operations and requests for this server
  endpoints: builder => ({
    // The `getBooks` endpoint is a "query" operation that returns data
    getBooks: builder.query({
      // The URL for the request is '/books'
      query: () => ({ url: '/books' }),
      providesTags: ['books']
    }),

    getPublishers: builder.query({
      query: () => ({ url: '/publishers' }),
      providesTags: ['publishers']
    }),

    getAuthors: builder.query({
      query: () => ({ url: '/authors' }),
      providesTags: ['authors']
    }),

    createBook: builder.mutation({
      query: (book) => ({
        url: '/books',
        method: 'POST',
        body: book
      }),
      invalidatesTags: ['books']
    }),

    deleteBook: builder.mutation({
      query: (id) => ({
        url: `/books/${id}`,
        method: 'DELETE'
      }),
      invalidatesTags: ['books']
    }),

    createPublisher: builder.mutation({
      query: (publisher) => ({
        url: '/publishers',
        method: 'POST',
        body: publisher
      }),
      invalidatesTags: ['publishers']
    }),

    createAuthor: builder.mutation({
      query: (author) => ({
        url: '/authors',
        method: 'POST',
        body: author
      }),
      invalidatesTags: ['authors']
    })
  })
})

// Export the auto-generated hook for the `getBooks` query endpoint
export const {
  useGetBooksQuery,
  useGetAuthorsQuery,
  useGetPublishersQuery,
  useCreateBookMutation,
  useDeleteBookMutation,
  useCreatePublisherMutation,
  useCreateAuthorMutation
} = apiSlice
