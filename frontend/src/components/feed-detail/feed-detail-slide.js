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
  width: 100%;
  align-items: center;

  div > img {
    width: 100%;
    height: 100%;
    max-height: calc(100vh - 70px);
    object-fit: contain;
  }
`;

function FeedDetailSlide({ images }) {
  const getSlide = (images) => {
    return images.map((src, i) => {
      return (
        <InnerCarousel key={i}>
          <div style={contentStyle}>
            <img src={src} />
          </div>
        </InnerCarousel>
      );
    });
  };

  const NextArrow = (props) => {
    const { className, onClick } = props;
    return (
      <div
        className={className}
        style={{
          zIndex: 1,
          right: '3%',
          background: 'gray',
          borderRadius: '50%',
        }}
        onClick={onClick}
      />
    );
  };

  const PrevArrow = (props) => {
    const { className, onClick } = props;
    return (
      <div
        className={className}
        style={{
          zIndex: 1,
          left: '3%',
          background: 'gray',
          borderRadius: '50%',
        }}
        onClick={onClick}
      />
    );
  };
  const settings = {
    swipeToSlide: true,
    arrows: true,
    draggable: true,
    nextArrow: <NextArrow />,
    prevArrow: <PrevArrow />,
  };

  return (
    <Wrapper>
      <Carousel {...settings} style={{ backgroundColor: '#3F3D3D' }}>
        {getSlide(images)}
      </Carousel>
    </Wrapper>
  );
}

export default FeedDetailSlide;
