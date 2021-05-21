import React, { Component } from 'react';
import Button from '@material-ui/core/Button';

export default function MoviesButton(props) {
    return (
        <Button variant="outlined" color={props.color == null ? "primary" : props.color} onClick={props.onClick} disabled={props.disabled} style={props.style} >
          {props.name}
        </Button>
    );
}
