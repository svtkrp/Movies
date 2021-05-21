import React from 'react';
import ReactDOM from 'react-dom';
import Typography from '@material-ui/core/Typography';
import { ThemeProvider } from '@material-ui/styles';

import DateMovies from './DateMovies.js';
import MoviesTheme from '../elems/MoviesTheme.js';

ReactDOM.render(
  <ThemeProvider theme={MoviesTheme()}>
  <div>
    <Typography component='h1' variant="h2" gutterBottom align='center' >
      Топ-10 фильмов
    </Typography>
    <Typography component='h2' variant="h5" gutterBottom align='center' style={{marginBottom: "30px"}}>
      Лучшие 10 фильмов всех времен и народов по версии пользователей Кинопоиска
    </Typography>
    
    <DateMovies />
  </div>
  </ThemeProvider>,
document.getElementById('root'));
