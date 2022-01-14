import { Footer } from 'antd/lib/layout/layout';
import React from 'react';
import styled from 'styled-components';
import { FOOTER } from '../../../constants';
import { FEED_DETAIL_URL } from '../../../constants/urls';
import { theme } from '../../../style/theme';

const FooterAntd = styled(Footer)`
  text-align: center;
  background-color: ${theme.colorWhite};
  padding: 0px 0px 2px 0px;
`;

function SiteFooter({ location }) {
  return location.pathname.includes(FEED_DETAIL_URL) ? (
    ''
  ) : (
    <FooterAntd>{FOOTER}</FooterAntd>
  );
}

export default SiteFooter;
