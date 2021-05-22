import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import Typography from '@material-ui/core/Typography';

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
    margin: 20,
  },
  paper: {
    padding: theme.spacing(2),
    margin: 'auto',
    maxWidth: 700,
  },
}));

export default function MoviesItem(props) {
  const classes = useStyles();

  return (
    <div className={classes.root}>
      <Paper className={classes.paper} elevation={3}>
        <Grid container spacing={2}>
          
          <Grid item xs={2}>
            <Typography gutterBottom variant="h5">
                  {props.m.position}
            </Typography>
          </Grid>
            
            <Grid item xs={8} container direction="column" spacing={2}>
              
              <Grid item>
                <Typography gutterBottom variant="h5" color="primary">
                    {props.m.nameRussian}
                </Typography>
              </Grid>
              
              <Grid item container>
                <Grid item>
                  <Typography gutterBottom variant="subtitle2" color="textSecondary">
                    {props.m.year}
                  </Typography>
                </Grid>
                <Grid item xs={1}>
                </Grid>
                <Grid item>
                  <Typography gutterBottom variant="subtitle2" color="textSecondary">
                    {(props.m.nameOriginal != null && props.m.nameOriginal != "") ? props.m.nameOriginal : "-"}
                  </Typography>
                </Grid>
              </Grid>
              
            </Grid>
            
            <Grid item xs={2} container direction="column" justify="center" alignItems="flex-end">
              <Grid item>
                <Typography gutterBottom variant="h4" color="secondary">
                      {String(props.m.value).substring(0, 1) + "." + String(props.m.value).substring(1, 2)}
                </Typography>
              </Grid>
              <Grid item>
                <Typography gutterBottom variant="body2" color="textSecondary">
                      {props.m.count}
                </Typography>
              </Grid>
            </Grid>
            
        </Grid>
      </Paper>
    </div>
  );
}

