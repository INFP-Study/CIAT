import React from 'react';
import FeedDetailContainer from '../containers/feed-detail-container';

function FeedDetail() {
  //상세보기 들어갈 때 스크롤 위치 상단으로 초기화
  window.scrollTo(0, 0);

  return <FeedDetailContainer />;
}

export default FeedDetail;
