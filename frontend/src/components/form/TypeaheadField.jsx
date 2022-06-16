import React from 'react'
import { useController/*, useFormContext */ } from 'react-hook-form'
import Form from 'react-bootstrap/Form'
import { Typeahead } from 'react-bootstrap-typeahead'

export default function TypeaheadField ({ fieldLabel, name, ...props }) {
  const {
    field: { ...inputProps },
    fieldState: { error }
  } = useController({
    // we are not using 'control' => there should be a parent FormProvider somewhere
    name
  })

  const invalid = error !== undefined

  if (error) {
    console.log(error)
  }

  const getComponent = () => <Typeahead
    { ...inputProps } {...props}
    // needed to fix Form.Control.Feedback visibility
    // see https://github.com/ericgio/react-bootstrap-typeahead/issues/432
    // see https://codesandbox.io/s/4w01px4z6x
    className={ invalid ? 'is-invalid' : ''}
    isInvalid={ invalid } />

  return <>
    {fieldLabel !== undefined ? <Form.Label>{fieldLabel}</Form.Label> : null}

    {getComponent()}

    <Form.Control.Feedback type="invalid" tooltip>
      {error?.message}
    </Form.Control.Feedback>
  </>
}
