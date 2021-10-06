import React from 'react';
import { Link } from 'react-router-dom';
import { MAIN_URL, SIGNIN_URL } from '../../constants/urls';

function index() {
  return (
    <div>
      <ul>
        <li>
          <Link to={MAIN_URL}>Home</Link>
        </li>
        <li>
          <Link to={SIGNIN_URL}>login</Link>
        </li>
      </ul>
      <hr />
    </div>
  );
}

export default index;
