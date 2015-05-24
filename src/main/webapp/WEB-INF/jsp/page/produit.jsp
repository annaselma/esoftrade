<div class="widget">
									<div class="widget-header">
										<h3><i class="fa fa-magic"></i> Wizard</h3>
									</div>
									<div class="widget-content">
										<div class="wizard-wrapper">
											<div id="demo-wizard" class="wizard">
												<ul class="steps">
													<li data-target="#step1" class="active"><span class="badge badge-info">1</span>Account Type<span class="chevron"></span></li>
													<li data-target="#step2" class=""><span class="badge">2</span>User Account<span class="chevron"></span></li>
													<li data-target="#step3" class=""><span class="badge">3</span>Options<span class="chevron"></span></li>
													<li data-target="#step4" class="last"><span class="badge">4</span>Create Account</li>
												</ul>
											</div>
											<div class="step-content">
												<div class="step-pane active" id="step1">
													<form id="form1" data-parsley-validate="" novalidate="">
														<p>Choose your account type:</p>
														<label class="fancy-radio parsley-success">
															<input type="radio" name="account-type" value="personal" required="" data-parsley-errors-container="#error-step1" data-parsley-multiple="account-type" data-parsley-id="9014">
															<span><i></i>Personal</span>
														</label>
														<label class="fancy-radio">
															<input type="radio" name="account-type" value="business" data-parsley-multiple="account-type" data-parsley-id="9014">
															<span><i></i>Business</span>
														</label>
														<label class="fancy-radio">
															<input type="radio" name="account-type" value="enterprise" data-parsley-multiple="account-type" data-parsley-id="9014">
															<span><i></i>Enterprise</span>
														</label>
														<p id="error-step1"><ul class="parsley-errors-list" id="parsley-id-multiple-account-type"></ul></p>
													</form>
												</div>
												<div class="step-pane" id="step2">
													<form id="form2" data-parsley-validate="" novalidate="">
														<p>Please provide email, username and password
															<br>
															<em><small>Field marked * is required</small></em>
														</p>
														<div class="row">
															<div class="col-md-3">
																<div class="form-group">
																	<label for="email">Email *</label>
																	<input type="email" id="email" class="form-control parsley-success" required="" data-parsley-id="7427"><ul class="parsley-errors-list" id="parsley-id-7427"></ul>
																</div>
																<div class="form-group">
																	<label for="password">Password *</label>
																	<input type="password" id="password" name="password" class="form-control parsley-success" required="" data-parsley-id="0516"><ul class="parsley-errors-list" id="parsley-id-0516"></ul>
																</div>
																<div class="form-group">
																	<label for="password2">Repeat Password *</label>
																	<input type="password" id="password2" name="password2" class="form-control parsley-success" required="" data-parsley-equalto="#password" data-parsley-equalto-message="Password doesn't match." data-parsley-id="2394"><ul class="parsley-errors-list" id="parsley-id-2394"></ul>
																</div>
															</div>
														</div>
													</form>
												</div>
												<div class="step-pane" id="step3">
													<form id="form3" data-parsley-validate="" novalidate="">
														<label class="fancy-checkbox">
															<input type="checkbox" name="newsletter" data-parsley-multiple="newsletter" data-parsley-id="4513">
															<span>Subscribe to monthly newsletter</span>
														</label><ul class="parsley-errors-list" id="parsley-id-multiple-newsletter"></ul>
														<label class="fancy-checkbox">
															<input type="checkbox" name="terms" data-parsley-multiple="terms" data-parsley-id="8041">
															<span>I accept the <a href="#">Terms &amp; Agreements</a></span>
														</label><ul class="parsley-errors-list" id="parsley-id-multiple-terms"></ul>
													</form>
												</div>
												<div class="step-pane" id="step4">
													<p class="lead"><i class="fa fa-check-circle text-success"></i> All is well! Click "Create My Account" to complete.</p>
												</div>
											</div>
											<div class="actions">
												<button type="button" class="btn btn-default btn-prev"><i class="fa fa-arrow-left"></i> Prev</button>
												<button type="button" class="btn btn-next btn-primary">Next <i class="fa fa-arrow-right"></i></button>
											</div>
										</div>
									</div>
								</div>