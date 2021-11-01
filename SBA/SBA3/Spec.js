describe('Should navigate to Demo Page', () => {

	
	browser.get('http://localhost:4200/');

	it('Url verification', () => {
		browser.getCurrentUrl().then((url) => {
			expect(url).toBe('http://localhost:4200/');		
		});
		console.log("Url verification Succesfull")
	});

	it('Checking heading ', function() {
		
		var tx = element(by.id('2')).getText();
		tx.then((txt)=>{
			expect(txt).toBe('AngularJS Sample Application');	
		})	
	});

	it('Checking FirstName', function() {
		var fsname = element(by.id('fsname'));
		expect(fsname.getAttribute('value')).toBe("Mahesh")	
	})


	it(' ChangingFirstname', function() {
		
		var fsname = element(by.id('fsname'));
		browser.sleep(1000)
		fsname.clear()
		browser.sleep(1000)
		fsname.sendKeys('sholmes')
		expect(fsname.getAttribute('value')).toBe("sholmes")	
		browser.sleep(1000)
	})

	
	it('Checking Lastnname', function() {
		var Lsname = element(by.id('Lsname'));
		expect(Lsname.getAttribute('value')).toBe("Parashar")	
	})

	

	
	it('Checking Fullname', function() {

		var Fulnme = element(by.binding('student.fullName()'));
		expect(Fulnme.getText()).toBe('sholmes Parashar');	
			
	})

	var tb = element.all(by.id('3'));

	it('Checking 1st row', () => {
		expect(tb.get(0).getText()).toBe('Java');	
	});	

	it('Checking 2nd row', () => {
		expect(tb.get(1).getText()).toBe('Sql');	
	});	

	it('Checking 3rd row', () => {
		expect(tb.get(2).getText()).toBe('Mongodb');	
	});	

	it('Checking 4rth row', () => {
		expect(tb.get(3).getText()).toBe('python');	
	});	

	it('Checking 5th row', () => {
		expect(tb.get(4).getText()).toBe('C++');	
	});



	var favorite = element(by.binding('RadioButton.my.favorite'));
	var rd = element.all(by.model('RadioButton.my.favorite'));

	
	it('1st option value check in rdbtn', function() {
		rd.get(0).click();

		rd.isSelected().then(bsel => {
			console.log("is radio button selected",bsel)
		})
		
		expect(favorite.getText()).toBe('Cypress');
		browser.sleep(3000);
	});
	
	
	
	it('2nd option value check  in rdbtn', function() {
		rd.get(1).click();
		expect(favorite.getText()).toBe('Jasmine');
		browser.sleep(2000);
	});

	
	
	it('3rd option value check  in rdbtn', function() {
		rd.get(2).click();
		expect(favorite.getText()).toBe('Karma');
		browser.sleep(2000);
	});


	it('4rth option value check  in rdbtn', function() {
		rd.get(3).click();
		expect(favorite.getText()).toBe('Protractor');
		browser.sleep(2000);
	});


	var rd1 = element.all(by.id('chkbx'));

	
	it('1st option value check in chkbox', function() {
		rd1.get(0).click();
		browser.sleep(1000);
		expect(rd1.get(0).getText()).toBe('Java');
		rd1.get(0).click();
	});

	it('2nd option value check in chkbox', function() {
		rd1.get(1).click();
		browser.sleep(1000);
		expect(rd1.get(1).getText()).toBe('Sql');
		rd1.get(1).click();
	});

	it('3rd option value check in chkbox', function() {
		rd1.get(2).click();
		browser.sleep(1000);
		expect(rd1.get(2).getText()).toBe('Mongodb');
		rd1.get(2).click();
	});

	it('4rth option value check in chkbox', function() {
		rd1.get(3).click();
		browser.sleep(1000);
		expect(rd1.get(3).getText()).toBe('Python');
		rd1.get(3).click();
	});


	
	var dp

	
	it('1st option  dropdown', function() {


		dp =element.all(by.id('optn'));
		var dp1 = element.all(by.id('dpn'));
		dp1.click()
		browser.sleep(2000)
		element(by.css("#dpn [ngvalue='Java']")).click();;
		expect(dp.get(0).getText()).toBe('Java');
		browser.sleep(1000);
		
	});

	it('2nd option  dropdown', function() {
		
		
		element(by.css("#dpn [ngvalue='Sql']")).click();;
		expect(dp.get(1).getText()).toBe('Sql');
		browser.sleep(1000);
		
	});
	

	it('3rd option  dropdown', function() {
		
		
		element(by.css("#dpn [ngvalue='Mongodb']")).click();;
		expect(dp.get(2).getText()).toBe('Mongodb');
		browser.sleep(1000);
		
	});

	it('4rth option  dropdown', function() {
		
		
		element(by.css("#dpn [ngvalue='Python']")).click();;
		expect(dp.get(3).getText()).toBe('Python');
		browser.sleep(1000);
		
	});
	
});
