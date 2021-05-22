import React from 'react';
import axios from 'axios';

import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import { MuiPickersUtilsProvider } from '@material-ui/pickers';
import DateFnsUtils from '@date-io/date-fns';

import Movies from './Movies.js';
import MoviesDateTimePicker from '../elems/MoviesDateTimePicker.js';
import MoviesButton from '../elems/MoviesButton.js';
import getDateStr from './getDateStr.js';
   
class DateMovies extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      selectedDate: new Date(),
      movies: [],
      isEmpty: true
    };
    this.handleDateChange = this.handleDateChange.bind(this);
  }
  
  componentDidMount() {
    this.doRequest();
  }
  
  doRequest() {
    const api = axios.create({
      baseURL: `http://localhost:1563/`,
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin':'*',
      }
    });
    
    api.get(`movies?date=${getDateStr(this.state.selectedDate)}`)
      .then(res => {
        const moviesRes = res.data;
        const isEmptyRes = (moviesRes.length === 0);
        this.setState({ movies: moviesRes, isEmpty: isEmptyRes });
      });
  }

  handleDateChange(date) {
    this.setState({ selectedDate: date });
  }

  render() {
  return (
    <MuiPickersUtilsProvider utils={DateFnsUtils}>
      <Grid container direction="row" justify="center" alignItems="center" spacing={2}>
        <Grid item>
          <MoviesDateTimePicker value={this.state.selectedDate} onChange={(date) => this.handleDateChange(date)} />
        </Grid>
        <Grid item>
          <MoviesButton name="Показать на эту дату" onClick={() => this.doRequest()} />
        </Grid>
      </Grid>
      
      <Movies items={this.state.movies} />
      
      <Typography variant="h6" gutterBottom align='center' style={this.state.isEmpty ? {display: 'block', marginTop: "30px"} : {display: 'none', marginTop: "30px"}}>
        Статистика на эту дату и даты ранее не была сохранена. Выберите более позднюю дату.
      </Typography>
    
    </MuiPickersUtilsProvider>
  );
  }
}

export default DateMovies;
