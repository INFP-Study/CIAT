import React from 'react';
import SiteLayout from '../components/common/layout';
import FeedDetailContainer from '../containers/feed-detail-container';

function FeedDetail(props) {
  return (
    <SiteLayout>
      <FeedDetailContainer />
    </SiteLayout>
  );
}

export default FeedDetail;
