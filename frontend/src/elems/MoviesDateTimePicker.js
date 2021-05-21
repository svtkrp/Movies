import React, { useState } from "react";
import { DateTimePicker } from "@material-ui/pickers";

function MoviesDateTimePicker(props) {

  return (
    <DateTimePicker
        autoOk
        ampm={false}
        disableFuture
        value={props.value}
        onChange={props.onChange}
        inputVariant="outlined"
        label="Выберите дату и время"
      />
  );
}

export default MoviesDateTimePicker;
