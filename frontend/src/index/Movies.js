import React from 'react';

import MoviesItem from '../elems/MoviesItem.js';

export default function Movies(props) {

  return (
    <div> {
      props.items.sort(function(a, b) { return a.position - b.position; })
                 .map((item) => <MoviesItem m={item} />) 
    } </div>
  );
}

