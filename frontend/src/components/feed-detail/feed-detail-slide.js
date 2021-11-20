import React from 'react';
import { Carousel } from 'antd';
import styled from 'styled-components';

const Wrapper = styled.div`
  height: 755px;
  min-height: 100%;
  min-width: 0px;
  width: 0px;
  flex-basis: 1200px;
  flex-grow: 3;

  .slick-track {
    display: flex !important;
  }

  .slick-slide {
    height: auto;
  }
`;

const contentStyle = {
  height: '755px',
  color: '#fff',
  lineHeight: '755px',
  textAlign: 'center',
  background: '#364d79',
};

function onChange(a, b, c) {
  console.log(a, b, c);
}

function FeedDetailSlide() {
  return (
    <Wrapper>
      <Carousel swipeToSlide draggable>
        <div>
          <h3 style={contentStyle}>1</h3>
        </div>
        <div>
          <h3 style={contentStyle}>2</h3>
        </div>
        <div>
          <h3 style={contentStyle}>3</h3>
        </div>
        <div>
          <h3 style={contentStyle}>4</h3>
        </div>
      </Carousel>
    </Wrapper>
  );
}

export default FeedDetailSlide;
