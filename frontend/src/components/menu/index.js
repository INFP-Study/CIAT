import React from 'react';
import { Link } from 'react-router-dom';

function index() {
  return (
    <div>
      <ul>
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/login">login</Link>
        </li>
      </ul>
      <hr />
    </div>
  );
}

export default index;
