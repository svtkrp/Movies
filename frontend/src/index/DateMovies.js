import React from 'react';
import axios from 'axios';

import Grid from '@material-ui/core/Grid';
import { MuiPickersUtilsProvider } from '@material-ui/pickers';
import DateFnsUtils from '@date-io/date-fns';

import Movies from './Movies.js';
import MoviesDateTimePicker from '../elems/MoviesDateTimePicker.js';
import MoviesButton from '../elems/MoviesButton.js';
   
class DateMovies extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      selectedDate: new Date(),
      movies: []
    };
    this.handleDateChange = this.handleDateChange.bind(this);
  }
  
  // yyyy-MM-dd'T'HH:mm:ss, zone - GMT
  getDateStr(date) {
    return "" + date.getUTCFullYear() + "-" + this.get2NumbersStr(date.getUTCMonth() + 1) + "-" + this.get2NumbersStr(date.getUTCDate())
      + "T" + this.get2NumbersStr(date.getUTCHours()) + ":" + this.get2NumbersStr(date.getUTCMinutes()) + ":" + this.get2NumbersStr(date.getUTCSeconds());
  }
  
  get2NumbersStr(num) {
    return ((num < 10) ? "0" : "") + num;
  }
  
  componentDidMount() {
    this.doRequest();
  }
  
  doRequest() {
    axios.get(`http://localhost:1563/movies?date=${this.getDateStr(this.state.selectedDate)}`)
      .then(res => {
      console.log(res);
        const moviesRes = res.data;
        this.setState({ movies: moviesRes });
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
    </MuiPickersUtilsProvider>
  );
  }
}

export default DateMovies;
