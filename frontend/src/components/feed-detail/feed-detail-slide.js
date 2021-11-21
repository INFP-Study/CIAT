import React from 'react';
import { Carousel } from 'antd';
import styled from 'styled-components';

const Wrapper = styled.div`
  min-width: 0px;
  width: 0px;
  flex-basis: 1200px;
  flex-grow: 3;
  flex-shrink: 3;
  height: 100%;

  .slick-track {
    display: flex !important;
  }

  .slick-slide {
  }
`;

const contentStyle = {
  color: '#fff',
  display: 'flex',
  flexDirection: 'column',
  alignItems: 'center',
};

const InnerCarousel = styled.div`
  display: flex;
  min-height: 100%;
  height: 100%;
  width: auto;
  align-items: center;

  div > img {
    width: auto;
    height: 100%;
    max-height: 600px;
    object-fit: contain;
  }
`;

function onChange(a, b, c) {
  console.log(a, b, c);
}

function FeedDetailSlide() {
  return (
    <Wrapper>
      <Carousel swipeToSlide draggable style={{ backgroundColor: '#3F3D3D' }}>
        <InnerCarousel>
          <div style={contentStyle}>
            <img src="https://images.unsplash.com/photo-1619463284209-1215aeda42c8?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=687&q=80" />
          </div>
        </InnerCarousel>
        <InnerCarousel>
          <div style={contentStyle}>
            <img src="https://images.unsplash.com/photo-1619463284209-1215aeda42c8?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=687&q=80" />
          </div>
        </InnerCarousel>
        <InnerCarousel>
          <div style={contentStyle}>
            <img src="https://images.unsplash.com/photo-1501004318641-b39e6451bec6?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1073&q=80" />
          </div>
        </InnerCarousel>
        <InnerCarousel>
          <h3 style={contentStyle}>3</h3>
        </InnerCarousel>
        <InnerCarousel>
          <h3 style={contentStyle}>4</h3>
        </InnerCarousel>
      </Carousel>
    </Wrapper>
  );
}

export default FeedDetailSlide;
