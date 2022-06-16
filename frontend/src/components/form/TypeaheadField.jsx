import React from 'react'
import { useController } from 'react-hook-form'
import Form from 'react-bootstrap/Form'
import { Typeahead } from 'react-bootstrap-typeahead'

export default function TypeaheadField ({ fieldLabel, name, options, ...props }) {
  const {
    field: { ...inputProps },
    fieldState: { error }
  } = useController({
    // we are not using 'control' => there should be a parent FormProvider somewhere
    name
  })

  const invalid = error !== undefined

  const getComponent = () => <Typeahead
    { ...inputProps } {...props}
    options={options}

    // needed to fix Form.Control.Feedback visibility
    // see https://github.com/ericgio/react-bootstrap-typeahead/issues/432
    // see https://codesandbox.io/s/4w01px4z6x
    className={ invalid ? 'is-invalid' : ''}
    isInvalid={ invalid }

    // 'selected' property should be used in controlled scenario - like this
    selected={ inputProps.value }
    />

  return <>
    {fieldLabel !== undefined ? <Form.Label>{fieldLabel}</Form.Label> : null}

    {getComponent()}

    <Form.Control.Feedback type="invalid" tooltip>
      {error?.message}
    </Form.Control.Feedback>
  </>
}
