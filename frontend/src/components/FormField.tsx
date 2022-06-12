import React from 'react'
import { useController, useFormContext } from 'react-hook-form'
import Form from 'react-bootstrap/Form'

export default function FormField ({ fieldLabel, name, ...props }: any): JSX.Element {
  const {
    field: { ...inputProps },
    fieldState: { error }
  } = useController({
    // we are not using 'control' => there should be a parent FormProvider somewhere
    name
  })

  const { register } = useFormContext()
  const invalid: boolean = error !== undefined

  const getComponent = (): JSX.Element => {
    if (props.as === 'select') {
      // select still use field data from useController
      // because otherwise is not possible to bind the value
      // to selects with options that changes between rerenders
      return (
        <Form.Select { ...inputProps } {...props} isInvalid={ invalid } />
      )
    } else if (props.type === 'checkbox') {
      return (
        <Form.Check {...register(name) } {...props} isInvalid={ invalid } />
      )
    } else {
      return (
        <Form.Control {...register(name) } {...props} isInvalid={ invalid } />
      )
    }
  }

  return <>
    { fieldLabel !== undefined ? <Form.Label>{fieldLabel}</Form.Label> : null }

    { getComponent() }

    <Form.Control.Feedback type="invalid" tooltip>
      {error?.message}
    </Form.Control.Feedback>
  </>
}
