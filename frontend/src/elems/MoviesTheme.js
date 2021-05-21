import { createMuiTheme } from '@material-ui/core/styles';

export default function MoviesTheme() {
  return createMuiTheme({
    palette: {
      primary: {
        main: '#009e00',
      },
      secondary: {
        main: '#55b5ff',
      },
    },
  });
}
