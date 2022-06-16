import { useMemo } from 'react'

// error argument holds errors returned by a RTK Query mutation
// (called REST service is a supposed to be based on Spring Boot)
// setFormError argument should be the setError function returned
// by react-hook-form framework (through useForm or useFormContext hooks)
export const useMutationErrors = (error, setFormError) => {
  return useMemo(
    () => {
      error?.data?.errors?.forEach(validationError => {
        setFormError(
          validationError.field, {
            type: 'server',
            message: validationError.defaultMessage
          })
      })
    },
    [error, setFormError]
  )
}
