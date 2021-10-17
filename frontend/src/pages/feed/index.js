import React from 'react';
import SiteLayout from '../../components/common/layout';
import { FEED_DAILY_URL } from '../../constants/urls';

function Feed(props) {
  const { match } = props;
  console.log(match);
  return <SiteLayout>Feed {match.url === FEED_DAILY_URL && '일상'}</SiteLayout>;
}

export default Feed;
